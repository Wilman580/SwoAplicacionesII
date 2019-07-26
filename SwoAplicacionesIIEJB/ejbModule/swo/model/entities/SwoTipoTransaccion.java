package swo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the swo_tipo_transaccion database table.
 * 
 */
@Entity
@Table(name="swo_tipo_transaccion")
@NamedQuery(name="SwoTipoTransaccion.findAll", query="SELECT s FROM SwoTipoTransaccion s")
public class SwoTipoTransaccion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SWO_TIPO_TRANSACCION_CODIGOTIPOTRANS_GENERATOR", sequenceName="SEQ_$NAME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SWO_TIPO_TRANSACCION_CODIGOTIPOTRANS_GENERATOR")
	@Column(name="codigo_tipo_trans")
	private Integer codigoTipoTrans;

	@Column(name="descripcion_trans")
	private String descripcionTrans;

	@Column(name="tipo_trans")
	private String tipoTrans;

	//bi-directional many-to-one association to SwoDetallesInventario
	@OneToMany(mappedBy="swoTipoTransaccion")
	private List<SwoDetallesInventario> swoDetallesInventarios;

	public SwoTipoTransaccion() {
	}

	public Integer getCodigoTipoTrans() {
		return this.codigoTipoTrans;
	}

	public void setCodigoTipoTrans(Integer codigoTipoTrans) {
		this.codigoTipoTrans = codigoTipoTrans;
	}

	public String getDescripcionTrans() {
		return this.descripcionTrans;
	}

	public void setDescripcionTrans(String descripcionTrans) {
		this.descripcionTrans = descripcionTrans;
	}

	public String getTipoTrans() {
		return this.tipoTrans;
	}

	public void setTipoTrans(String tipoTrans) {
		this.tipoTrans = tipoTrans;
	}

	public List<SwoDetallesInventario> getSwoDetallesInventarios() {
		return this.swoDetallesInventarios;
	}

	public void setSwoDetallesInventarios(List<SwoDetallesInventario> swoDetallesInventarios) {
		this.swoDetallesInventarios = swoDetallesInventarios;
	}

	public SwoDetallesInventario addSwoDetallesInventario(SwoDetallesInventario swoDetallesInventario) {
		getSwoDetallesInventarios().add(swoDetallesInventario);
		swoDetallesInventario.setSwoTipoTransaccion(this);

		return swoDetallesInventario;
	}

	public SwoDetallesInventario removeSwoDetallesInventario(SwoDetallesInventario swoDetallesInventario) {
		getSwoDetallesInventarios().remove(swoDetallesInventario);
		swoDetallesInventario.setSwoTipoTransaccion(null);

		return swoDetallesInventario;
	}

}
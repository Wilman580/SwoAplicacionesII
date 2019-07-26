package swo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the swo_caras database table.
 * 
 */
@Entity
@Table(name="swo_caras")
@NamedQuery(name="SwoCara.findAll", query="SELECT s FROM SwoCara s")
public class SwoCara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SWO_CARAS_CODIGOCAR_GENERATOR", sequenceName="SEQ_$NAME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SWO_CARAS_CODIGOCAR_GENERATOR")
	@Column(name="codigo_car")
	private Integer codigoCar;

	@Column(name="descripcion_car")
	private String descripcionCar;

	@Column(name="nombre_car")
	private String nombreCar;

	//bi-directional many-to-one association to SwoOdontograma
	@OneToMany(mappedBy="swoCara")
	private List<SwoOdontograma> swoOdontogramas;

	public SwoCara() {
	}

	public Integer getCodigoCar() {
		return this.codigoCar;
	}

	public void setCodigoCar(Integer codigoCar) {
		this.codigoCar = codigoCar;
	}

	public String getDescripcionCar() {
		return this.descripcionCar;
	}

	public void setDescripcionCar(String descripcionCar) {
		this.descripcionCar = descripcionCar;
	}

	public String getNombreCar() {
		return this.nombreCar;
	}

	public void setNombreCar(String nombreCar) {
		this.nombreCar = nombreCar;
	}

	public List<SwoOdontograma> getSwoOdontogramas() {
		return this.swoOdontogramas;
	}

	public void setSwoOdontogramas(List<SwoOdontograma> swoOdontogramas) {
		this.swoOdontogramas = swoOdontogramas;
	}

	public SwoOdontograma addSwoOdontograma(SwoOdontograma swoOdontograma) {
		getSwoOdontogramas().add(swoOdontograma);
		swoOdontograma.setSwoCara(this);

		return swoOdontograma;
	}

	public SwoOdontograma removeSwoOdontograma(SwoOdontograma swoOdontograma) {
		getSwoOdontogramas().remove(swoOdontograma);
		swoOdontograma.setSwoCara(null);

		return swoOdontograma;
	}

}
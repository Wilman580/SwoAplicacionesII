package swo.model.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the swo_categorias database table.
 * 
 */
@Entity
@Table(name="swo_categorias")
@NamedQuery(name="SwoCategoria.findAll", query="SELECT s FROM SwoCategoria s")
public class SwoCategoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SWO_CATEGORIAS_CODIGOCAT_GENERATOR", sequenceName="SEQ_$NAME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SWO_CATEGORIAS_CODIGOCAT_GENERATOR")
	@Column(name="codigo_cat")
	private Integer codigoCat;

	@Column(name="descripcion_cat")
	private String descripcionCat;

	@Column(name="nombre_cat")
	private String nombreCat;

	//bi-directional many-to-one association to SwoTratamiento
	@OneToMany(mappedBy="swoCategoria")
	private List<SwoTratamiento> swoTratamientos;

	public SwoCategoria() {
	}

	public Integer getCodigoCat() {
		return this.codigoCat;
	}

	public void setCodigoCat(Integer codigoCat) {
		this.codigoCat = codigoCat;
	}

	public String getDescripcionCat() {
		return this.descripcionCat;
	}

	public void setDescripcionCat(String descripcionCat) {
		this.descripcionCat = descripcionCat;
	}

	public String getNombreCat() {
		return this.nombreCat;
	}

	public void setNombreCat(String nombreCat) {
		this.nombreCat = nombreCat;
	}

	public List<SwoTratamiento> getSwoTratamientos() {
		return this.swoTratamientos;
	}

	public void setSwoTratamientos(List<SwoTratamiento> swoTratamientos) {
		this.swoTratamientos = swoTratamientos;
	}

	public SwoTratamiento addSwoTratamiento(SwoTratamiento swoTratamiento) {
		getSwoTratamientos().add(swoTratamiento);
		swoTratamiento.setSwoCategoria(this);

		return swoTratamiento;
	}

	public SwoTratamiento removeSwoTratamiento(SwoTratamiento swoTratamiento) {
		getSwoTratamientos().remove(swoTratamiento);
		swoTratamiento.setSwoCategoria(null);

		return swoTratamiento;
	}

}
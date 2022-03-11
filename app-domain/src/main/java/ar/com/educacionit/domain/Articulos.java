package ar.com.educacionit.domain;

import java.util.Date;

public class Articulos implements Entity {

	// atributos
	private Long id;
	private String titulo;
	private Date fechaCreacion;
	private String codigo;
	private Double precio;
	private Long stock;
	private Long marcasId;
	// private Marcas marca;
	private Long categoriasId;
	private Categorias categorias;

	// constructor
	// alt+shift+s

	// hacia la db

	public Articulos() {

	}

	public Articulos(String titulo, Date fechaCreacion, String codigo, Double precio, Long stock, Long marcasId,
			Long categoriasId) {
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
	}

	// desde la db
	public Articulos(Long id, String titulo, Date fechaCreacion, String codigo, Double precio, Long stock,
			Long marcasId, Long categoriasId) {
		this.id = id;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcasId;
		this.categoriasId = categoriasId;
	}

	// metodos

	public Articulos(Long id, String titulo, Double precio) {
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
	}

	public Double getPrecio() {
		return this.precio;
	}

	public String getPrecio(String pattern) {
		// ##,###.00
		return this.precio.toString();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTitulo(Boolean isUpperCase) {
		if (isUpperCase) {
			return this.titulo.toUpperCase();
		} else {
			return this.titulo;
		}
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getMarcasId() {
		return marcasId;
	}

	public void setMarcasId(Long marcasId) {
		this.marcasId = marcasId;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriasId) {
		this.categoriasId = categoriasId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", codigo=" + codigo
				+ ", precio=" + precio + ", stock=" + stock + ", marcasId=" + marcasId + ", categoriasId=" + categoriasId
				+ "]";
	}

}

package models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_BENEFIT")
public class ProductBenefit {
	@EmbeddedId
	private ProductBenenfitId id;
	@ManyToOne
	@MapsId("productId")
	@JoinColumn(name = "PRODUCT_ID", nullable = false)
	public Product product;
	@ManyToOne
	@MapsId("purposeId")
	@JoinColumn(name = "PURPOSE_ID", nullable = false)
	private Purpose purpose;
}

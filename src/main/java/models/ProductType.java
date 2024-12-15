package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCT_TYPE")
public class ProductType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "NAME", columnDefinition = "varchar(20)")
	private String name;
	@Column(name = "DECRIPTION", columnDefinition = "varchar(50)")
	private String decription;
	@Column(name = "ACTIVE")
	private boolean active;

//	 Cấu hình liên kết
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "TYPE_ID")
	private List<Product> products;
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "PURPOSE_ID")
	private List<Purpose> purposes;
	@ManyToOne
	@JoinColumn(name = "PARENT_ID")
	private ProductType parent;
	@OneToMany(mappedBy = "parent")
	private List<ProductType> child;
	public ProductType() {
		active=true;
	}
}

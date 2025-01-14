package services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import dao.GenericDao;
import models.CartItem;
import models.Orders;
import models.Brand;
import models.Product;
import models.ProductAttributes;
import models.ProductCategory;
import models.Topic;
import utils.QueryUtil;

public class ProductService {
	public static List<Topic> getAllTopic() {
		return GenericDao.getAll(Topic.class);
	}

	public static Brand getBrand(Integer id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Brand.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(Brand.class, Brand.class, query, id);
	}

	public static Product findProduct(Integer idProduct) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Product.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(Product.class, Product.class, query, idProduct);
	}

	public static List<ProductCategory> getChildCategory(Integer parentId) {
		String condition = QueryUtil.createCondition("parent.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(ProductCategory.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetList(ProductCategory.class, ProductCategory.class, query, parentId);
	}

	public static ProductCategory getCategory(Integer id) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(ProductCategory.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetSingle(ProductCategory.class, ProductCategory.class, query, id);
	}

	public static List<Brand> getBrandsByCategory(Integer categoryId) throws NullPointerException {
		if (categoryId == null)
			throw new NullPointerException("categoryId null");
		String condition = QueryUtil.createCondition("category.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Product.class, "brand", condition);
		return GenericDao.excuteQueryGetList(Product.class, Brand.class, query, categoryId);
	}

	private static List<Integer> getAllCategoryByParentId(Integer parentId) {
		String condition = QueryUtil.createCondition("parent.id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(ProductCategory.class, QueryUtil.ALL, condition);
		List<ProductCategory> temp = GenericDao.excuteQueryGetList(ProductCategory.class, ProductCategory.class, query,
				parentId);
		List<Integer> allCategoryIds = new ArrayList<>();
		for (ProductCategory category : temp) {
			allCategoryIds.add(category.getId());
			List<Integer> subCategories = getAllCategoryByParentId(category.getId());
			allCategoryIds.addAll(subCategories);
		}
		return allCategoryIds;
	}

	public static List<Brand> getAllBrandsByCategory(Integer categoryId) {
		List<Integer> categories = getAllCategoryByParentId(categoryId);
		categories.add(categoryId);
		List<String> conditions = new LinkedList<String>();
		List<Object> datas = new LinkedList<Object>();
		for (int i = 0; i < categories.size(); i++) {
			datas.add(categories.get(i));
			conditions.add(QueryUtil.createCondition("category.id", QueryUtil.EQUALS, i,
					i != categories.size() - 1 ? QueryUtil.OR : QueryUtil.EMPTY));
		}
		String query = QueryUtil.createQueryDistinct(Product.class, "brand", conditions.toArray(new String[0]));
		return GenericDao.excuteQueryGetList(Product.class, Brand.class, query, datas.toArray());
	}

	public static List<Product> getProductByCategory(Integer categoryId) {
		List<Integer> categories = getAllCategoryByParentId(categoryId);
		categories.add(categoryId);
		List<String> conditions = new LinkedList<String>();
		List<Object> datas = new LinkedList<Object>();
		for (int i = 0; i < categories.size(); i++) {
			datas.add(categories.get(i));
			conditions.add(QueryUtil.createCondition("category.id", QueryUtil.EQUALS, i,
					i != categories.size() - 1 ? QueryUtil.OR : QueryUtil.EMPTY));
		}
		String query = QueryUtil.createQuery(Product.class, QueryUtil.ALL, conditions.toArray(new String[0]));
		return GenericDao.excuteQueryGetList(Product.class, Product.class, query, datas.toArray());
	}

	public static List<Product> getProductByFilter(Integer categoryId, Integer brandId, Integer[] attributes) {
		int index = 0;
		List<String> conditions = new ArrayList<String>();
		List<Object> data = new ArrayList<Object>();
		if (categoryId != null) {
			conditions.add(QueryUtil.createCondition("category.id", QueryUtil.EQUALS, index++,
					brandId != null || attributes != null ? QueryUtil.AND : QueryUtil.EMPTY));
			data.add(categoryId);

		}
		if (brandId != null) {
			conditions.add(QueryUtil.createCondition("brand.id", QueryUtil.EQUALS, index++,
					attributes != null ? QueryUtil.AND : QueryUtil.EMPTY));
			data.add(brandId);
		}
		String query = null;
		if (attributes != null) {
			conditions.add(QueryUtil.createConditionJoin("id", QueryUtil.IN, index, QueryUtil.EMPTY));
			data.add(Arrays.asList(attributes));
			query = QueryUtil.createQueryJoin(Product.class, ProductAttributes.class, QueryUtil.ALL, "id",
					conditions.toArray(new String[0]));
		} else
			query = QueryUtil.createQuery(Product.class, QueryUtil.ALL, conditions.toArray(new String[0]));
		return GenericDao.excuteQueryGetList(Product.class, Product.class, query, data.toArray());
	}

	/**
	 * Lấy sản phẩm
	 */
	public static Product getProduct(Integer productIds) {
		String condition = QueryUtil.createCondition("id", QueryUtil.EQUALS, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(Product.class, QueryUtil.ALL, condition);
//		List<Product> products = GenericDao.excuteQueryGetList(Product.class, Product.class, query, productIds);
		return GenericDao.excuteQueryGetSingle(Product.class, Product.class, query, productIds);
	}

	public static List<ProductCategory> getParentCategory(Object object) {
		String condition = QueryUtil.createCondition("parent.id", QueryUtil.IS_NULL, 0, QueryUtil.EMPTY);
		String query = QueryUtil.createQuery(ProductCategory.class, QueryUtil.ALL, condition);
		return GenericDao.excuteQueryGetList(ProductCategory.class, ProductCategory.class, query, new Object[0]);
	}

}

package models.id;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class TopicCategoryId implements Serializable {
	private static final long serialVersionUID = -7723429605739692746L;
	private Integer topicId;
	private Integer categoryId;

	@Override
	public int hashCode() {
		return Objects.hash(topicId, categoryId);
	}

	public Integer getTopicId() {
		return topicId;
	}

	public void setTopicId(Integer topicId) {
		this.topicId = topicId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopicCategoryId other = (TopicCategoryId) obj;
		return topicId == other.topicId && categoryId == other.categoryId;
	}
}

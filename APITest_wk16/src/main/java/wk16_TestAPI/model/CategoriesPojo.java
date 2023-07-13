package wk16_TestAPI.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CategoriesPojo {



        private String name;
        private String createdAt;
        private String updatedAt;
        private List<Object> subCategories;
//        private List<CategoryPath> categoryPath;
        private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();




        public String getName() {
        return name;
    }

        public void setName(String name) {
        this.name = name;
    }

        public String getCreatedAt() {
        return createdAt;
    }

        public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

        public String getUpdatedAt() {
        return updatedAt;
    }

        public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

        public List<Object> getSubCategories() {
        return subCategories;
    }

        public void setSubCategories(List<Object> subCategories) {
        this.subCategories = subCategories;
    }

//        public List<CategoryPath> getCategoryPath() {
//        return categoryPath;
//    }
//
//        public void setCategoryPath(List<CategoryPath> categoryPath) {
//        this.categoryPath = categoryPath;
//    }

        public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

        public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    }






package oneshot.model.dto;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "메뉴 모델", description = "메뉴 정보")
public class Menu {
    private int menuId;
    private int brandId;
    private String menuName;
    private String img;
    private int price;
    private String size;
    private String temperature;
    private String type;
    private String createdTime;
    private String updatedTime;

    public Menu() {
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void update(int menuId, Menu oldMenu) {
        this.menuId = menuId;
        if (this.menuName == null) {
            this.menuName = oldMenu.menuName;
        }
        if (this.img == null) {
            this.img = oldMenu.img;
        }
        if (this.price == 0) {
            this.price = oldMenu.price;
        }
        if (this.size == null) {
            this.size = oldMenu.size;
        }
        if (this.temperature == null) {
            this.temperature = oldMenu.temperature;
        }
        if (this.type == null) {
            this.type = oldMenu.type;
        }
    }
}

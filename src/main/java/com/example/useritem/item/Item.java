package com.example.useritem.item;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "item_brand")
    private String itemBrand;

    @Column(name = "model_no")
    private String modelNo;

    @Column(name = "item_name")
    private String itemName;

    @Column(name = "item_color")
    private String itemColor;

    @Column(name = "release_date")
    private String releaseDate;

    @Column(name = "sold_out")
    private Boolean soldOut;


    @Builder //-> test 에서 보면 빌더 생성 되는 방식이있다. 어노테이션으로 퉁친다.
    public Item(String itemBrand, String itemName, String itemColor) {
        this.itemBrand = itemBrand;
        this.itemName = itemName;
        this.itemColor = itemColor;
    }

    @Override
    public String toString() {
        return String.format("아이템 스펙: %s, %s, %s ", itemBrand, itemName, itemColor);
    }

}

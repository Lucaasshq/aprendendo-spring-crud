package com.Lucas.aprendendo_spring_crud.domain.product;

import lombok.Getter;
import lombok.Setter;


public record RequestProduct(String name, Integer price_in_cents) {

}

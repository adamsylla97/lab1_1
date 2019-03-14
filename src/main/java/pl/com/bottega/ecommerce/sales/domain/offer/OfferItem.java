/*
 * Copyright 2011-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package pl.com.bottega.ecommerce.sales.domain.offer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class OfferItem {

    private ProductData productData;

    private Discount discount;

    private Money totalCost;

    private int quantity;

    public OfferItem(ProductData productData, int quantity) {
        this(productData, quantity, null);
    }

    public OfferItem(ProductData productData, int quantity, Discount discount) {
        this.productData = productData;
        this.quantity = quantity;
        this.discount = discount;
        //this.discountCause = discountCause;

        BigDecimal discountValue = new BigDecimal(0);
        if (discount != null) {
            discountValue = discountValue.add(discount.getAmmount().getValue());
        }

        this.totalCost.setValue(productData.getPrice().getValue().multiply(new BigDecimal(quantity)).subtract(discountValue));
    }

    public ProductData getProductData() {
        return productData;
    }

    public Discount getDiscount() {
        return discount;
    }

    public Money getTotalCost() {
        return totalCost;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productData, discount, quantity, totalCost);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        OfferItem other = (OfferItem) obj;
        return Objects.equals(productData, other.getProductData()) && Objects.equals(discount, other.discount) && Objects.equals(totalCost,
                other.getTotalCost()) && quantity == other.quantity;
    }

    /**
     * @param other
     * @param delta acceptable percentage difference
     * @return
     */
    public boolean sameAs(OfferItem other, double delta) {
//        if (productPrice == null) {
//            if (other.productPrice != null) {
//                return false;
//            }
//        } else if (!productPrice.equals(other.productPrice)) {
//            return false;
//        }
//        if (productName == null) {
//            if (other.productName != null) {
//                return false;
//            }
//        } else if (!productName.equals(other.productName)) {
//            return false;
//        }
//
//        if (productId == null) {
//            if (other.productId != null) {
//                return false;
//            }
//        } else if (!productId.equals(other.productId)) {
//            return false;
//        }
//        if (productType != other.productType) {
//            return false;
//        }

        if(productData == null){
            if(other.productData != null){
                return false;
            }
        } else if (!productData.sameAs(other.productData)){
            return false;
        }

        if (quantity != other.quantity) {
            return false;
        }

        BigDecimal max;
        BigDecimal min;
        if (totalCost.getValue().compareTo(other.totalCost.getValue()) > 0) {
            max = totalCost.getValue();
            min = other.totalCost.getValue();
        } else {
            max = other.totalCost.getValue();
            min = totalCost.getValue();
        }

        BigDecimal difference = max.subtract(min);
        BigDecimal acceptableDelta = max.multiply(BigDecimal.valueOf(delta / 100));

        return acceptableDelta.compareTo(difference) > 0;
    }

}

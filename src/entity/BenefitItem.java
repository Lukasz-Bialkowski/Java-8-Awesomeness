package entity;

import enumeration.BenefitItemType;

/**
 * Created by luke_bialkowski on 4/17/2016.
 */
public class BenefitItem {

    BenefitItemType type;

    public BenefitItem(BenefitItemType type) {
        this.type = type;
    }

    public BenefitItemType getType() {

        return type;
    }

    public void setType(BenefitItemType type) {
        this.type = type;
    }
}

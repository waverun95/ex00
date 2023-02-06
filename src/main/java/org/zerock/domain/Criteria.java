package org.zerock.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Data
public class Criteria {

    private int pageNum;
    private int amount;
    private int beginPage;

    public Criteria(){
        this(1,10);
    }
    public Criteria(int pageNum, int amount){
        this.pageNum = pageNum;
        this.amount = amount;
        System.out.println("pageNum = " + pageNum);
        System.out.println("amount = " + amount);
        this.beginPage = ((this.pageNum-1)*this.amount) + 1;
        System.out.println("beginPage = " + beginPage);
    }
}

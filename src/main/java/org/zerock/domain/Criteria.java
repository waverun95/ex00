package org.zerock.domain;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
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
    }

    public int getBeginPage() {
        return this.beginPage = ((this.pageNum-1)*this.amount) + 1;
    }

}

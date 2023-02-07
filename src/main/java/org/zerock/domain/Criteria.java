package org.zerock.domain;

import lombok.*;
import org.springframework.web.util.UriComponentsBuilder;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Criteria {

    private int pageNum;
    private int amount;
    private int beginPage;

    private String type;
    private String keyword;


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
        return this.beginPage = ((this.pageNum-1)*this.amount);
    }

    public String[] getTypeArr(){
        return type == null? new String[] {}:type.split("");
    }

    public String getListLink(){

        UriComponentsBuilder builder = UriComponentsBuilder.fromPath("")
                .queryParam("pageNum",this.pageNum)
                .queryParam("amount",this.getAmount())
                .queryParam("type",this.getType())
                .queryParam("keyword", this.getKeyword());
        return builder.toUriString();
    }
}

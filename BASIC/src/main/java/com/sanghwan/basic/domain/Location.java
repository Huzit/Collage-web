package com.sanghwan.basic.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor

@Entity
@Table(name="Location")
public class Location implements Serializable{

         @Id
         @Column
         @GeneratedValue(strategy = GenerationType.AUTO)
         private Long idx;

         @Column
         private String address;

         @Column
         private String postcode;

         @Builder
         public Location(String address, String postcode) {
              this.address = address;
              this.postcode = postcode;
    }
}

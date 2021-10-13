package com.neo.saving.domain.entity;

import com.neo.saving.constant.SavingPurpose;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Saving extends BaseEntity{

   @Column
   Integer tenor;

   @Column
   Integer firstDepositAmount;

   @Column
   Integer monthlyDepositAmount;

   @Enumerated(EnumType.STRING)
   @Column
   SavingPurpose savingPurpose;

}

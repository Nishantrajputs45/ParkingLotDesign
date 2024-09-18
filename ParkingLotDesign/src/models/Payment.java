package models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class Payment extends BaseModel{
    private int amount;
    private PaymentStatus status;
    private String transactionId; //Payment Gateway transaction id...
    private PaymentMode paymentMode;
    private Bill bill;
    private Date paymentTime;


}

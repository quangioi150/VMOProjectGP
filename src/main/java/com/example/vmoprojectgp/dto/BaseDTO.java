package com.example.vmoprojectgp.dto;

import java.time.Instant;
import java.util.Date;

public class BaseDTO {
    private Date create_date = Date.from(Instant.now());
    private Date update_date = Date.from(Instant.now());

    public BaseDTO() {
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }
}

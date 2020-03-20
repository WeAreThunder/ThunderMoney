package com.thunder.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
//添加构造函数
@AllArgsConstructor
//添加无参构造函数
@NoArgsConstructor
public class Payment implements Serializable {
    /**
    * ID
    */
    private Long id;

    private String serial;
}
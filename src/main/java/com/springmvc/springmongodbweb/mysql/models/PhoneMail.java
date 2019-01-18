/**
 * 
 */
package com.springmvc.springmongodbweb.mysql.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author tuanhiep225
 *
 */
@Entity
@Table(name = "cms_trung_ci_data")
@Data
public class PhoneMail {
	@Id
    private String id;
    private String uid;
    private String phone;
}

package com.NUExpenseManagementSystem.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;


import lombok.Data;

@Entity
@Data
@Table(name="ExpenseCategory", uniqueConstraints = {
		@UniqueConstraint(columnNames = {"expense_category_name"})
})
//@SQLDelete(sql = "UPDATE expense_category SET del_flg = true WHERE expense_cat_id=?")
//@FilterDef(
//        name = "deletedCategoryFilter",
//        parameters = @ParamDef(name = "isDeleted", type = "boolean")
//)
//@Filter(
//        name = "deletedCategoryFilter",
//        condition = "del_flg = :isDeleted"
//)

public class ExpenseCategory {
	    @Id
    	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long expense_cat_id;
	    private String expense_category_name;
	    private Boolean del_flg = Boolean.FALSE;
}

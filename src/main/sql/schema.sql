create database department_manage CHARACTER set 'utf8';

create TABLE department(
  department_id INT not NULL AUTO_INCREMENT COMMENT '部门id',
  department_name VARCHAR(90) NOT NULL COMMENT '部门名称',
  parent_id INT NOT NULL COMMENT '上级部门id',
  create_time DATETIME COMMENT '创建时间',
  update_time TIMESTAMP DEFAULT current_timestamp COMMENT '更新时间',
  PRIMARY KEY (department_id)
)ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET = utf8 COMMENT '部门表';

SELECT * from department;

INSERT INTO department(department_name, parent_id, create_time) VALUES ('董事局',0,sysdate());
INSERT INTO department(department_name, parent_id, create_time) VALUES ('主管部',1000,sysdate());
INSERT INTO department(department_name, parent_id, create_time) VALUES ('经理部',1001,sysdate());
INSERT INTO department(department_name, parent_id, create_time) VALUES ('信息部',1002,sysdate());
INSERT INTO department(department_name, parent_id, create_time) VALUES ('销售部',1002,sysdate());

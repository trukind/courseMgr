package edu.coursemgr.common;

/**
 * Created by chenxianzhang on 2018/8/24 0024 上午 1:38
 */
public class CommonEnum {

    public enum StudentTaskStatus {
        FINISHED("FINISHED", "完成"),
        TO_REVIEW("TO_REVIEW", "待完成"),
        UNCOMMITTED("UNCOMMITTED", "未提交");

        private String value;
        private String name;

        StudentTaskStatus(String value, String name) {
            this.value = value;
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    public enum GroupedType {
        ASSIGN("指定"),
        FREEDOM("自由分组"),
        RAND("随机分组");

        private String name;

        GroupedType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public enum Role {
        ADMIN("admin"),
        TEACHER("teacher"),
        STUDENT("student");

        private String value;

        Role(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum StuExcelHeader {
        NAME("姓名"),
        STUDENT_ID("学号"),
        COLLEGE("学院"),
        PROFESSIONAL("专业"),
        CELLPHONE("电话"),
        SEX("性别"),
        EMAIL("邮箱");

        private int index;

        private String text;

        StuExcelHeader(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

}

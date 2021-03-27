package com.ljp.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSafeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Integer offset;

    public UserSafeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNull() {
            addCriterion("last_login_date is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIsNotNull() {
            addCriterion("last_login_date is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateEqualTo(Date value) {
            addCriterion("last_login_date =", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotEqualTo(Date value) {
            addCriterion("last_login_date <>", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThan(Date value) {
            addCriterion("last_login_date >", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login_date >=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThan(Date value) {
            addCriterion("last_login_date <", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateLessThanOrEqualTo(Date value) {
            addCriterion("last_login_date <=", value, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateIn(List<Date> values) {
            addCriterion("last_login_date in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotIn(List<Date> values) {
            addCriterion("last_login_date not in", values, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateBetween(Date value1, Date value2) {
            addCriterion("last_login_date between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginDateNotBetween(Date value1, Date value2) {
            addCriterion("last_login_date not between", value1, value2, "lastLoginDate");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("last_login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("last_login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("last_login_ip =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("last_login_ip <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("last_login_ip >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_ip >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("last_login_ip <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("last_login_ip <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("last_login_ip like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("last_login_ip not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("last_login_ip in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("last_login_ip not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("last_login_ip between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("last_login_ip not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacIsNull() {
            addCriterion("last_login_mac is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacIsNotNull() {
            addCriterion("last_login_mac is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacEqualTo(String value) {
            addCriterion("last_login_mac =", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacNotEqualTo(String value) {
            addCriterion("last_login_mac <>", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacGreaterThan(String value) {
            addCriterion("last_login_mac >", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_mac >=", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacLessThan(String value) {
            addCriterion("last_login_mac <", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacLessThanOrEqualTo(String value) {
            addCriterion("last_login_mac <=", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacLike(String value) {
            addCriterion("last_login_mac like", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacNotLike(String value) {
            addCriterion("last_login_mac not like", value, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacIn(List<String> values) {
            addCriterion("last_login_mac in", values, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacNotIn(List<String> values) {
            addCriterion("last_login_mac not in", values, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacBetween(String value1, String value2) {
            addCriterion("last_login_mac between", value1, value2, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginMacNotBetween(String value1, String value2) {
            addCriterion("last_login_mac not between", value1, value2, "lastLoginMac");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceIsNull() {
            addCriterion("last_login_source is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceIsNotNull() {
            addCriterion("last_login_source is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceEqualTo(String value) {
            addCriterion("last_login_source =", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceNotEqualTo(String value) {
            addCriterion("last_login_source <>", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceGreaterThan(String value) {
            addCriterion("last_login_source >", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceGreaterThanOrEqualTo(String value) {
            addCriterion("last_login_source >=", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceLessThan(String value) {
            addCriterion("last_login_source <", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceLessThanOrEqualTo(String value) {
            addCriterion("last_login_source <=", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceLike(String value) {
            addCriterion("last_login_source like", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceNotLike(String value) {
            addCriterion("last_login_source not like", value, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceIn(List<String> values) {
            addCriterion("last_login_source in", values, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceNotIn(List<String> values) {
            addCriterion("last_login_source not in", values, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceBetween(String value1, String value2) {
            addCriterion("last_login_source between", value1, value2, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andLastLoginSourceNotBetween(String value1, String value2) {
            addCriterion("last_login_source not between", value1, value2, "lastLoginSource");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("update_date is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("update_date is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterion("update_date =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterion("update_date <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterion("update_date >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("update_date >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterion("update_date <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterion("update_date <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterion("update_date in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterion("update_date not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterion("update_date between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterion("update_date not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andRegisterDataIsNull() {
            addCriterion("register_data is null");
            return (Criteria) this;
        }

        public Criteria andRegisterDataIsNotNull() {
            addCriterion("register_data is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterDataEqualTo(Date value) {
            addCriterion("register_data =", value, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataNotEqualTo(Date value) {
            addCriterion("register_data <>", value, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataGreaterThan(Date value) {
            addCriterion("register_data >", value, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataGreaterThanOrEqualTo(Date value) {
            addCriterion("register_data >=", value, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataLessThan(Date value) {
            addCriterion("register_data <", value, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataLessThanOrEqualTo(Date value) {
            addCriterion("register_data <=", value, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataIn(List<Date> values) {
            addCriterion("register_data in", values, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataNotIn(List<Date> values) {
            addCriterion("register_data not in", values, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataBetween(Date value1, Date value2) {
            addCriterion("register_data between", value1, value2, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterDataNotBetween(Date value1, Date value2) {
            addCriterion("register_data not between", value1, value2, "registerData");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNull() {
            addCriterion("register_source is null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIsNotNull() {
            addCriterion("register_source is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceEqualTo(String value) {
            addCriterion("register_source =", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotEqualTo(String value) {
            addCriterion("register_source <>", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThan(String value) {
            addCriterion("register_source >", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceGreaterThanOrEqualTo(String value) {
            addCriterion("register_source >=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThan(String value) {
            addCriterion("register_source <", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLessThanOrEqualTo(String value) {
            addCriterion("register_source <=", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceLike(String value) {
            addCriterion("register_source like", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotLike(String value) {
            addCriterion("register_source not like", value, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceIn(List<String> values) {
            addCriterion("register_source in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotIn(List<String> values) {
            addCriterion("register_source not in", values, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceBetween(String value1, String value2) {
            addCriterion("register_source between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterSourceNotBetween(String value1, String value2) {
            addCriterion("register_source not between", value1, value2, "registerSource");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressIsNull() {
            addCriterion("register_adress is null");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressIsNotNull() {
            addCriterion("register_adress is not null");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressEqualTo(String value) {
            addCriterion("register_adress =", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressNotEqualTo(String value) {
            addCriterion("register_adress <>", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressGreaterThan(String value) {
            addCriterion("register_adress >", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressGreaterThanOrEqualTo(String value) {
            addCriterion("register_adress >=", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressLessThan(String value) {
            addCriterion("register_adress <", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressLessThanOrEqualTo(String value) {
            addCriterion("register_adress <=", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressLike(String value) {
            addCriterion("register_adress like", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressNotLike(String value) {
            addCriterion("register_adress not like", value, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressIn(List<String> values) {
            addCriterion("register_adress in", values, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressNotIn(List<String> values) {
            addCriterion("register_adress not in", values, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressBetween(String value1, String value2) {
            addCriterion("register_adress between", value1, value2, "registerAdress");
            return (Criteria) this;
        }

        public Criteria andRegisterAdressNotBetween(String value1, String value2) {
            addCriterion("register_adress not between", value1, value2, "registerAdress");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
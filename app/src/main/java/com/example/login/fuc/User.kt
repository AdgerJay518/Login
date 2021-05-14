package com.example.login.fuc

class User(name: String, password: String) {
    private var name //用户名
            : String? = null
    private var password //密码
            : String? = null

    fun User(name: String?, password: String?) {
        this.name = name
        this.password = password
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getPassword(): String? {
        return password
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    override fun toString(): String {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}'
    }
}

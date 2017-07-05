#乐鲜在线商城模块说明：
* LeXian-Common : 公共模块，一些公共组件，工具类都放到这个模块中.
* LeXian-Dao : 数据库交互模块，Mybatis的mapper.xml文件及Dao层的接口就写到这里.
* LeXian-Model : 对象模块，所有的实体对象都放到这里 .
* LeXian-Service:业务模块，业务接口及其实现都放到这里，事务控制也是在Service中 .
* LeXian-Admin:后台管理系统.
* LeXian-WebSite:乐鲜商城主页网站.
> 设置模块之间的依赖关系 
LeXian-Dao：依赖于LeXian-Model
LeXian-Service：依赖于LeXian-Model、LeXian-Dao 、LeXian-Common
LeXian-Web：依赖于LeXian-Service、eXian-Model、LeXian-Common，由于Maven的依赖关系是传递性的，
因此LeXian-WebSite、LeXian-Admin只需要依赖于LeXian-Service，就会间接的依赖LeXian-Model、LeXian-Dao、 LeXian-Common。

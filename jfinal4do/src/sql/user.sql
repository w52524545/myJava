#namespace("user")


#sql("findUserByUid")
	select * from test_user where uid=?
#end

#end
# !/usr/bin/python3
# -*- coding: UTF-8 -*-

import pymysql

if __name__ == '__main__':
    # 打开数据库连接
    db = pymysql.connect(host='192.168.237.100',
                        port=3307,
                        user='root',
                        passwd='123456',
                        db='e3mall',
                        charset='utf8')

    # 使用 cursor() 方法创建一个游标对象 cursor
    cursor = db.cursor()

    # 使用 execute()  方法执行 SQL 查询
    sql = "SELECT * FROM e3mall.tb_item;"
    cursor.execute(sql)

    # 使用 fetchone() 方法获取单条数据.
    # data = cursor.fetchone()
    # 获取所有数据
    for row in cursor.fetchall():
        id = row[0]
        image = str(row[6])
        new_image = image.replace("image.e3mall.cn", "image.mymall.com")
        # print(new_image)

        update_sql = "UPDATE `e3mall`.`tb_item` SET `image`='"+ new_image +"' WHERE `id`="+ str(id) +";"
        # print(update_sql)
        db.cursor().execute(update_sql)
    print('共查找出', cursor.rowcount, '条数据')
    db.commit()

    # 关闭数据库连接
    db.close()
#interrupt()
虽然名字是中断、停止的意思,但是并不能停止当前线程;
##个人理解：
相当于我给这个线程一个标识,这个线程我要停止,使线程对象的isInterrupted()返回true,在返回true的时候抛出异常停止此线程,这是停止线程最优的方案;

#interrupted()
此方法用与判断当前线程是否为中断状态,如果当前线程为中断状态,会清除该状态标志。 第二次调用会返回false

#isInterrupted()
判断当前线程是否位中断状态,但不会清除状态标志。


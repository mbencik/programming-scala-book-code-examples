// src/script/scala/progscala3/rounding/If.scala

import progscala3.rounding.WeekDay

WeekDay.values foreach { day =>
  if WeekDay.isWorkingDay(day) then
    println(s"$day is a working day")
  else if day == WeekDay.Sat then
    println("It's Saturday")
  else
    println("It's Sunday")
}

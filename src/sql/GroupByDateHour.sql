SQL Server :
SELECT [activity_dt], count(*)
FROM table1
GROUP BY DATEPART(day, [activity_dt]), DATEPART(hour, [activity_dt]);
Oracle :

SELECT [activity_dt], count(*)
FROM table1
GROUP BY TO_CHAR(activity_dt, 'DD'), TO_CHAR(activity_dt, 'hh');
MySQL :

SELECT [activity_dt], count(*)
FROM table1
GROUP BY hour( activity_dt ) , day( activity_dt )
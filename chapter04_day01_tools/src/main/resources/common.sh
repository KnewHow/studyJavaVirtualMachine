jps -l|grep -v "jps"|awk -F "[ ]+"  '{print $1}'

#!/bin/bash
# wait-for-postgres.sh

set -e

host="$1"
shift
cmd="$@"

echo $host
echo $MYSQL_USER
echo $MYSQL_PASSWORD

until mysql -h$host -P3306 -u$MYSQL_USER -p$MYSQL_PASSWORD  -e'exit'; do
  >&2 echo "Mysql is unavailable - sleeping"
  sleep 1
done

>&2 echo "Mysql is up - executing command"
exec $cmd
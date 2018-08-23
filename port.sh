#!/bin/bash
echo "> Git Pull"

git pull

echo "> 프로젝트 Build 시작"

./gradlew build

echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f webservice)

echo "$CURRENT_PID"

if [ -z $CURRENT_PID ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -2 $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 1
fi

echo "> 새 어플리케이션 배포"

JAR_NAME=$(ls / |grep 'Spring_Boot' | tail -n 1)

echo "> JAR Name: $JAR_NAME"

java -jar build/libs/webservice-0.0.2.jar --server.port=9000

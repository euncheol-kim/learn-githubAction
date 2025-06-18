#!/bin/bash
set -e

# 프로젝트 루트로 이동 (중요!)
cd "$(dirname "$0")/.."

echo "🚀 MySQL 컨테이너 시작..."
docker-compose -p learn-githubaction-test -f docker/docker-compose-test.yml up -d

echo "⏳ MySQL 준비 대기 중..."
sleep 10

echo "🧪 테스트 실행..."
./gradlew test -Dspring.profiles.active=test

echo "🧹 컨테이너 정리..."
docker-compose -p learn-githubaction-test -f docker/docker-compose-test.yml down

echo "✅ 테스트 완료!"
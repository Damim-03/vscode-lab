#!/bin/bash
# run-tests.sh - يكمبايل ويشغل كل الـ tests

set -e

JUNIT_CP=$(find /usr/share/java -name "*.jar" | grep -E "junit|opentest|apiguardian" | tr '\n' ':')

echo "==> Compiling main sources..."
mkdir -p out
javac -d out $(find src/main -name "*.java")

echo "==> Compiling test sources..."
mkdir -p out-test
javac -cp "out:${JUNIT_CP}" -d out-test $(find src/test -name "*.java")

echo "==> Running tests..."
java -cp "out:out-test:${JUNIT_CP}" \
  org.junit.platform.console.ConsoleLauncher \
  --scan-class-path="out-test" \
  --disable-ansi-colors

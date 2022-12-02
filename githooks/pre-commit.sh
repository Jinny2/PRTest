#!/bin/bash

echo "Run git pre-commit hook"

./gradlew app:ktlintCheck -- daemon

STATUS=$?

# retturn 1 exit code if running checks fails
[ $STATUS -ne 0 ] && exit 1
exit 0

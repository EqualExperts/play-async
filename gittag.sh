#!/bin/bash

# adds a git tag to the repo in a predefined format

function error() {
  echo "$@"
  exit 1
}

function log() {
  echo "$@"
}

if [ $# -lt 1 ]
  then
    error "Script requires an argument of the tag version"
fi

TAG_NAME="${1}"
PROJECT_NAME=${PWD##*/}
RELEASE_CANDIDATE_VERSION=$(git describe)
COMMIT_SHA=$(git rev-parse origin/master)
COMMIT_AUTHOR=$(git config user.name)
COMMIT_DATE=$(date '+%Y-%m-%d %H:%M:%S')

GIT_MSG=$(cat <<-END
Git Project        : ${PROJECT_NAME}
Release            : ${TAG_NAME}
Release candidate  : ${RELEASE_CANDIDATE_VERSION}

Last commit sha    : ${COMMIT_SHA}
Last commit author : ${COMMIT_AUTHOR}
Last commit time   : ${COMMIT_DATE}
END
)

git tag -a "v${TAG_NAME}" -m "${GIT_MSG}"

git push origin "v${TAG_NAME}"


/*
 * Copyright 2017 Equal Experts
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.equalexperts.play.asyncmvc.repository

import com.equalexperts.play.asyncmvc.model.TaskCache

import scala.concurrent.Future

case class TaskCachePersist(id: String, task:TaskCache)

trait AsyncCache {
  def save(expectation: TaskCache, expire:Long): Future[TaskCachePersist]
  def findByTaskId(id: String): Future[Option[TaskCachePersist]]
  def removeById(id: String): Future[Unit]
}

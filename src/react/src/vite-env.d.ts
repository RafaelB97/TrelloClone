/// <reference types="vite/client" />

interface ListInterface {
  id: number
  title: string
  description: string
  tasks: Array<TaskInterface>
}

interface TaskInterface {
  id: number
  title: string
  description: string
  finish: boolean
  data: string
}

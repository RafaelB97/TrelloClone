import { FormEvent, useState } from "react"
import { Form, Button } from "react-bootstrap"

interface AddTaskProps {
  listId: number
}

const AddTask = ({ listId }: AddTaskProps) => {
  const [name, setName] = useState('')

  const submit = async (e: FormEvent) => {
    e.preventDefault()
    console.log(name, listId)

    const response = await fetch(`/api/v1/list/${listId}/task`, {
      method: "POST",
      headers: {"Content-Type": "application/json",},
      body: JSON.stringify({
        title: name,
      })
    })

    const json = await response.json()
    console.log('Task response')
    console.log(json)
  }

  return (
    <>
      <Form onSubmit={submit}>
        <p>{name}</p>
        <Form.Control
          type="text"
          placeholder="Enter new task"
          value={name}
          onChange={e => setName(e.target.value)}
        />
        <Button
          variant="primary"
          type="submit"
        >
          Add Task
        </Button>
      </Form>
    </>
  )
}

export default AddTask

import { useState } from 'react'
import { Button, Form, Card } from 'react-bootstrap'

interface FormProps {
  onAdd: (name: string, description: string) => Promise<void>
}

function AddList({onAdd}: FormProps) {
  const [name, setName] = useState('')
  const [description, setDescription] = useState('')

  const submit = async (e: MouseEvent) => {
    e.preventDefault()

    await onAdd(name, description)

    setName('')
    setDescription('')
  }

  return (
    <>
      <Card style={{ width: '18rem' }}>
        <Form>
          <h2>Create list</h2>
          <Form.Group className="mb-3" controlId="formBasicEmail">
            <Form.Label>List title</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter title"
              value={name}
              onChange={e => setName(e.target.value)}
            />
          </Form.Group>

          <Form.Group className="mb-3" controlId="formBasicPassword">
            <Form.Label>List description</Form.Label>
            <Form.Control
              type="text"
              placeholder="Enter description"
              value={description}
              onChange={e => setDescription(e.target.value)}
            />
          </Form.Group>
          <Button
            variant="primary"
            type="submit"
            onClick={submit}
          >
            Submit
          </Button>
        </Form>
      </Card>
    </>
  )
}

export default AddList

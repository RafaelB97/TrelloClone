import { ListGroup } from 'react-bootstrap'

interface TasksProps {
  tasks: Array<TaskInterface>
}

function Tasks({ tasks }: TasksProps) {
  return (
    <>
      <ListGroup className="list-group-flush">
        {
          tasks.map(task => (
            <ListGroup.Item>{task.title}</ListGroup.Item>
          ))
        }
      </ListGroup>
    </>
  )
}

export default Tasks

import { Card } from 'react-bootstrap'

import Tasks from './Tasks'
import AddTask from './AddTask'

interface ListProps {
  list: ListInterface
}

function List({list}: ListProps) {
  return (
    <>
      <Card style={{ width: '18rem' }}>
        <Card.Body>
          <Card.Title>{list.title}</Card.Title>
          <Card.Text>
            {list.description}
          </Card.Text>
        </Card.Body>
        <Tasks tasks={list.tasks}/>
        <AddTask listId={list.id}/>
      </Card>
    </>
  )
}

export default List

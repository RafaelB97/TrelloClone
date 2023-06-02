import List from './List'

interface ListsProps {
  lists: ListInterface[]
}

function Lists(props: ListsProps) {
  return (
    <>
      {props.lists.map(list => (
        <List key={list.id} list={list}/>
      ))}
    </>
  )
}

export default Lists

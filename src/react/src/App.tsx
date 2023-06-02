import { useEffect, useState } from 'react'
import AddList from './components/AddList'
import Lists from './components/Lists'

function App() {
    const [lists, setLists] = useState<ListInterface[]>([])
  useEffect(() => {
    const getLists = async () => {
      const listsFromServer = await fetchLists()
      setLists(listsFromServer)
    }

    getLists()
  }, [])

  const fetchLists = async () => {
    const res = await fetch('api/v1/list')
    const data = await res.json()

    console.log(data)
    return data
  }

  const addList = async (name: string, description: string) => {
    const response = await fetch('/api/v1/list', {
      method: "POST",
      headers: {"Content-Type": "application/json",},
      body: JSON.stringify({
        title: name,
        description
      })
    })

    const json = await response.json()
    console.log('Response:')
    console.log(json)
    setLists([...lists, json])
  }

  return (
    <>
      <AddList onAdd={addList}/>
      <Lists lists={lists}/>
    </>
  )
}

export default App

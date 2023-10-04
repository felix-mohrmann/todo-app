import axios from 'axios';

export const getAllTodos = () =>
  axios('/api/todo').then((response) => response.data);

export const postTodo = (description) =>
  axios({
    method: 'post',
    url: 'https://todo.felixmohrmann.com/api/todo',
    data: { description: description, status: 'OPEN' },
  });

export const putTodo = (todo) =>
  axios({
    method: 'put',
    url: `https://todo.felixmohrmann.com/api/todo/${todo.id}`,
    data: todo,
  });

export const deleteTodo = (id) =>
  axios({
    method: 'delete',
    url: `https://todo.felixmohrmann.com/api/todo/${id}`,
  });

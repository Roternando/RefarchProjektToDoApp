import {defaultResponseHandler, getConfig} from "@/api/fetch-utils";

import type {Todo} from "@/types/Todo.ts";

export function getAllTodos(): Promise<Todo[]> {
    return fetch("/api/backend-service/todo", getConfig())
        .then((response) => {
            defaultResponseHandler(response);
            return response.json();
        })
        .catch((err) => {
            defaultResponseHandler(err);
        });
}
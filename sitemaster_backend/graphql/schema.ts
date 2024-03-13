//graphql schema

export const typeDefs = `#graphql
type User{
  id:String  
  username:String   
  email:String   
  phone:Int      
  role:Role   
  myContractorId:String
  projects: [Project]
  createdAt:String  
  updatedAt:String
}

type Project{
  id: String  
  title:  String
  description:String   
  contractorId: String
  image: String
  worker: [Worker]
  createdAt: String
  updatedAt:String
}

type Worker{
  id: String 
  username: String
  projectId:String
  createdAt: String 
  updatedAt: String 
}

enum Role {
  CONTRACTOR
  EMPLOYEE
}

type Query{
    getAllUsers:[User!]!
    getAllWorkersByProjectId(id:String):[Project!]!
}

type Mutation {
  createUser(username:String, email:String, phone:Int,myContractorId:String, role:Role):User!
  addProject(title:String, description:String,contractorId:String, image:String):Project!
  addWorker(username:String,projectId:String):Worker!
}
`;

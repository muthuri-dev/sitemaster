//graphql schema

export const typeDefs = `#graphql
type User{
  id:String  
  username:String   
  email:String   
  phone:Int      
  role:Role   
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
  createdAt: String
  updatedAt:String
}

enum Role {
  CONTRACTOR
  EMPLOYEE
}

type Query{
    getAllUsers:[User!]!
}
`;

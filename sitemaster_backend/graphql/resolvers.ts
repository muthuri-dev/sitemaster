import { TContext } from "@/types";

export const resolvers = {
  Query: {
    getAllUsers: async (_parent: any, _args: any, context: TContext) => {
      const userList = await context.prisma.user.findMany();
      if (userList == null) {
        return "no user";
      }
      return userList;
    },
  },

  Mutation: {
    //check if the user already exists in the database first if not save the user
    createUser: async (_parent: any, args: any, context: TContext) => {
      return await context.prisma.user.create({
        data: {
          username: args.username,
          email: args.email,
          phone: args.phone,
          myContractorId: args.myContractorId,
          role: args.Role,
        },
      });
    },
    addProject: async (_parent: any, args: any, context: TContext) => {
      return await context.prisma.project.create({
        data: {
          title: args.title,
          description: args.description,
          contractorId: args.contractorId,
          image: args.image,
        },
      });
    },
    addWorker: async (_parent: any, args: any, context: TContext) => {
      return await context.prisma.worker.create({
        data: {
          username: args.username,
          projectId: args.projectId,
        },
      });
    },
  },
  Project: {
    worker: async (parent: any, _args: any, context: TContext) => {
      return await context.prisma.worker.findMany({
        where: {
          projectId: parent.id,
        },
      });
    },
  },
};

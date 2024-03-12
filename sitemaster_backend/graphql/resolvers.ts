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
};
